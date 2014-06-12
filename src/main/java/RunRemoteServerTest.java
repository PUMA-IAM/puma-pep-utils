/*******************************************************************************
 * Copyright 2014 KU Leuven Research and Developement - iMinds - Distrinet 
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *    
 *    Administrative Contact: dnet-project-office@cs.kuleuven.be
 *    Technical Contact: maarten.decat@cs.kuleuven.be
 *    Author: maarten.decat@cs.kuleuven.be
 ******************************************************************************/
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import puma.peputils.Action;
import puma.peputils.Environment;
import puma.peputils.Object;
import puma.peputils.PEP;
import puma.peputils.Subject;
import puma.peputils.thrift.PEPServer;
import puma.peputils.thrift.RemotePEPService;


public class RunRemoteServerTest {

	public static void main(String[] args) {
		// initialize log4j
		BasicConfigurator.configure();
		
		// set up server
		PEPServer handler = new PEPServer(new PEP() {
			
			@Override
			public boolean isAuthorized(Subject subject, Object object, Action action,
					Environment environment) {
				// do nothing
				return false;
			}
			
		});
		RemotePEPService.Processor<PEPServer> processor = new RemotePEPService.Processor<PEPServer>(handler);
		TServerTransport serverTransport;
		try {
			serverTransport = new TServerSocket(9090);
		} catch (TTransportException e) {
			e.printStackTrace();
			return;
		}
		TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
		
		System.out.println("Starting the server");
		server.serve();
	}

}
