package delta.DeltaQuery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;

public class GetAll {
	public void getAllDat(HttpSolrClient client) {
		ModifiableSolrParams params = new ModifiableSolrParams();

		params.set("qt", "/select");
		params.set("q", "*:*");
		params.set("rows", 50);
		params.set("wt", "json");
		try {

			client.query(params);
			System.out.println(client.query(params).getResponse());

			usingSolrQuery(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void usingSolrQuery(HttpSolrClient solr) throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery("*:*");
		query.setRows(50);
		QueryResponse response = solr.query(query);
		SolrDocumentList doc = response.getResults();
		System.out.println(doc);
		for(SolrDocument d: doc) {
			printValues(d);
		}
		
	}
	
	
	void printValues(SolrDocument doc) {

		List<String> list = new ArrayList<String>(doc.getFieldNames());
		for (String d : list) {
			for(String st : list) {
				System.out.println(doc.getFieldValue(st));
				System.out.println();
			}
		}
	}
}
