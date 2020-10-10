import socket
import threading
import handler as h
import pickle

# Class to store key value for each client
class ClientdatabseKeyValue:

	def __init__(self,username):
		self.valstore={}
		self.role='guest'
		self.username=username

	def changeRole(self):
		self.role='manager'

	def getValue(self,key):
		if(key not in self.valstore):
			return '<blank>'
		return self.valstore[key]

	def putValue(self,key,value):
		self.valstore[key]=value
		return 'Successfully Inserted Value'

	# Function to take action on the requests
	def actionOnRequest(self,request):
		result=[]
		for reqs in request:
			if(reqs['method'].lower()=='get'):
				result.append(self.getValue(reqs['key']))

			elif(reqs['method'].lower()=='put'):
				self.putValue(reqs['key'],reqs['value'])

			elif(reqs['method'].lower()=='upgrade'):
				self.changeRole()
				result.append('INFO: Role changed successfully')

			elif(reqs['method'].lower()=='getall'):
				if(self.role=='guest'):
					result.append(self.getValue(reqs['key']))
				elif(self.role=='manager'):
					res_str = []
					for key in Dict:
						val = Dict[key].valstore
						if reqs['key'] in val:
							if len(res_str)==0:
								res_str.append("ClientIP\tPort\tValue")	
							ip = key.rpartition(':')
							res_str.append(ip[0] + "\t" + ip[-1] + "\t" + val.get(reqs['key']))

					result.append("\n".join(res_str))

		return result

sockServer=h.createSocket(h.port)
print("Server started at {}:{}".format(sockServer.getsockname()[0],sockServer.getsockname()[1]))
Dict={}

# Function to service a client
def serviceClient(client, clientAddr):

	while True:
		try:
			requestC=clientAddr.recv(1024) # Receive the request dictionary
			requestC=pickle.loads(requestC)
			result=client.actionOnRequest(requestC)
			result=pickle.dumps(result)
			clientAddr.sendall(result)
		except:
			pass

def allow_new_conn():

	while(True):
		# Wait for a connection
		sockServer.listen(10)
		cAddr, addrServer = sockServer.accept()
		# Fetch username
		uname = addrServer[0]+":"+str(addrServer[1])
		print('Connected to client', uname)
		client=ClientdatabseKeyValue(uname) # Create client by that username
		Dict[uname]=client

		# Start a new thread for the sender
		sendThread=threading.Thread(target=serviceClient, args=[client,cAddr])
		sendThread.start()

allow_new_conn()