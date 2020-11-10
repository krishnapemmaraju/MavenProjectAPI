package com.restapi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class TestYamlFile {
	
	public void singleStrYaml() {
		Yaml yml = new Yaml();
		String str = "krishna: Automation";
		Map<String,String> yamlData = yml.load(str);
		System.out.println(yamlData.get("krishna"));
	}
	
	public void multiLineYaml() {
		Yaml yamlM = new Yaml();
		String str = "name: krishna\n" + "occupation: Automation\n" + "age: 35\n" + "skills: Java";
		Object obj = yamlM.load(str);
		
		Map<String,String> map = (Map<String, String>) obj;
		System.out.println("Name: " + map.get("name"));
		System.out.println(map);
	}
	
	public void getDataFromFile() throws FileNotFoundException {
		Yaml yamlF = new Yaml();
		String path = System.getProperty("user.dir")+"/Resources/config.yaml";
		Map<String,String> mapF =  yamlF.load(new FileInputStream(new File(path)));
		
		System.out.println(mapF.get("occupation"));
		System.out.println(mapF);
	}
	
	public static void main(String ar[]) throws FileNotFoundException {
		TestYamlFile yamlTest = new TestYamlFile();
		//yamlTest.singleStrYaml();
		//yamlTest.multiLineYaml();
		yamlTest.getDataFromFile();
	}
	
	

}
