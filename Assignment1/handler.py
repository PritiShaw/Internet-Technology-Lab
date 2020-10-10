import socket

port = 9999

def createSocket(port):
    s= socket.socket()
    s.bind(('127.0.0.1', port))
    return s

def establishConnection(port, ip=''):
    s=socket.socket()
    s.connect((ip, port))
    return s

def sendMessage(message, s):
    s.send(message.encode())

def allowConnection(s):
    s.listen(5)
    local_port, address = s.accept()
    return local_port, address
