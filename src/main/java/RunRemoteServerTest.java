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
