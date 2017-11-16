package delta.DeltaQuery;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.common.params.ModifiableSolrParams;

public class Indexing {
	public void FullImport(HttpSolrClient client) {
		ModifiableSolrParams params = new ModifiableSolrParams();
		
		try {
			/*
			 * params.set("command", "full-import"); QueryRequest request = new
			 * QueryRequest(params); request.setPath("/dataimport");
			 * client.request(request);
			 */

			params.set("qt", "/dataimport");
			params.set("command", "full-import");
			
			client.query(params);
			
			System.out.println(client.query(params).getResponse());
			System.out.println("Succesfully full import.....");
			client.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void DeltaImport(HttpSolrClient client) {
		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set("qt", "/dataimport");
		params.set("command", "delta-import");
		try {
			client.query(params);
			System.out.println("Done....");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
