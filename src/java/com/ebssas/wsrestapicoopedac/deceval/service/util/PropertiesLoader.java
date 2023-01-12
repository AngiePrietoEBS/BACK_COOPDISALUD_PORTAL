package com.ebssas.wsrestapicoopedac.deceval.service.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	
	public final static String PROPERTIES_FILE="portalFirma.properties.file";
		
    private static PropertiesLoader propsLoader = null;
    
    private Properties properties=null;
    
    private PropertiesLoader() throws Exception{
    	loadPropertiesFile();    	
    }
    
    private static PropertiesLoader getInstance() throws Exception{

        if (propsLoader == null) {
            System.out.println("CARGA LAS PROPIEDADES");
            propsLoader = new PropertiesLoader();            
        }

        return propsLoader;
    }
    
    public static String loadProperty(String key){
    	String value=null;
    	try{
    		value=getInstance().properties.getProperty(key);
    	}catch(Exception e){
    		System.out.println("Error cargando archivo de propiedades");
    		e.printStackTrace();
    	}
    	return value;
    }

    private void loadPropertiesFile() throws Exception{   
    	InputStream instr = null;
        try {
        	Properties p = System.getProperties();
        	String filePath=(String)p.get(PROPERTIES_FILE);
        	if(filePath!=null){
        		Properties props = new Properties();
        		instr = new FileInputStream(filePath);
        		props.load(instr);
        		properties=props;
        	}else{
        		Properties props = new Properties();
            	instr = this.getClass().getResourceAsStream(PROPERTIES_FILE);
            	props.load(instr);
            	properties=props;
        	}     
        }catch (Exception e) { 
        	throw e;    
        }finally{
        	try{
	    		if(instr!=null){
	    			instr.close();
	    		}
	    	}catch(IOException ex){
	    		ex.printStackTrace();
	    	}
        }
    }
    /**
     * Forces the reloading of properties file by setting to null
     * the singleton instance.
     */
    public static void forcePropertiesFileReload(){
    	propsLoader=null;
    }    

}

