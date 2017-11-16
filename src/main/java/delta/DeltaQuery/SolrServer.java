package delta.DeltaQuery;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.params.ModifiableSolrParams;

public class SolrServer {
	public void StartSolrServer() {
		String url = "http://localhost:8983/solr/testCore/";
		HttpSolrClient client = new HttpSolrClient.Builder(url).build();
		client.setParser(new XMLResponseParser());
		
		Indexing indexing = new Indexing();
		 //indexing.FullImport(client);		
	//	 indexing.DeltaImport(client);
		GetAll select = new GetAll();
		select.getAllDat(client);
	}

	public static void main(String[] args) {
		new SolrServer().StartSolrServer();
	}
}
