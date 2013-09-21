package com.media_moderator.article_data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import android.util.Log;

import com.orchestr8.android.api.AlchemyAPI;

public class GetAlchemyAPIInputStreamFromURL {
	
	private InputStream getAlchemyXMLInputSteamFromURL(String articleURL){
		
		String AlchemyAPI_Key = "4a9e6684e21377d7a7e39d64764d63ba8c6af782";
		
    	AlchemyAPI api = null;
    	try
    	{
    		api = AlchemyAPI.GetInstanceFromString(AlchemyAPI_Key);
    	}
    	catch( IllegalArgumentException ex )
    	{
    		Log.e("KeywordInputStream", "Error loading AlchemyAPI.  Check that you have a valid AlchemyAPI key set in the AlchemyAPI_Key variable.  Keys available at alchemyapi.com.");
    		return null;
    	}
    	Document doc = null;
		try {
			doc = api.URLGetText(articleURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    	Source xmlSource = new DOMSource(doc);
    	StreamResult outputTarget = new StreamResult(outputStream);
    	try {
			TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	InputStream is = new ByteArrayInputStream(outputStream.toByteArray());
    	return is;
    }
	
}