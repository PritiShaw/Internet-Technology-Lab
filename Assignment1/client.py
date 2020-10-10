import socket
import threading
import handler as h
import pickle
import sys

# Function to return a dictionary based on the request
def parseArgs(args):

	req=[]
	i=0
	while i<(len(args)):

		if(args[i].lower()=='get'):
			if(i==len(args)-1 or args[i+1].lower()=='put'): # Error case
				return 0,req
			else:
				req.append({'method':'get','key':args[i+1]})
				i=i+1

		elif(args[i].lower()=='put'):
			if(i==len(args)-2): # Error case
				return 0,req
			else:
				req.append({'method':'put','key':args[i+1],'value':args[i+2]})
				i=i+2

		elif(args[i].lower()=='getall'):
			if(i==len(args)-1): # Error case
				return 0,req
			else:
				req.append({'method':'getall','key':args[i+1]})
				i=i+1
					
		elif(args[i].lower()=='upgrade'):
			req.append({'method':'upgrade'})
		else:
			return 0,req
		i=i+1

	return 1,req

if len(sys.argv)<3:
	print("Please provide Server IP PORT and instructions")
	sys.exit(0)

sockClient=h.establishConnection(port=int(sys.argv[2]),ip=sys.argv[1])

if __name__ == "__main__":	
	# Take input	
	retVal,req=parseArgs(sys.argv[3:])

	if(retVal==0):
		print('Invalid arguments')
		sys.exit()

	req=pickle.dumps(req)
	# Send the dictionary through socket
	sockClient.sendall(req)

	# Wait for response
	response=sockClient.recv(1024)
	response=pickle.loads(response)

	print("\n".join(response))