package com.amazonaws.samples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

import java.util.ArrayList;
import java.util.Random;

import java.util.LinkedList;

public class DisplayTerrorists {

	public static String main()
	{
		ArrayList<Item> stuffs = connect();
		System.out.println("Terrorists:");
		
		String returnString = "";
		
		for(Item thing:stuffs)
		{
			System.out.println("TerroristID: " + thing.get("TerroristID"));
			System.out.println("Prisoner#: " + thing.get("1 Prisoner#"));
			System.out.println("Name: " + thing.get("2 Name"));
			System.out.println("# Victims: " + thing.get("3 # Victims"));
			System.out.println("Country: " + thing.get("4 Country From"));
			System.out.println("Attack: " + thing.get("5 Attack"));
			System.out.println("///////////////////////////////////////");
			
			returnString = returnString + "\n" + "Prisoner ID: " + thing.get("TerroristID") + "\n"
				     + "Prisoner #: " + thing.get("1 Prisoner#") + "\n"
				     + "Name: " +  thing.get("2 Name") + "\n"
				     + "# Victims: " + thing.get("3 # Victims") + "\n"
				     + "Country: " + thing.get("4 Country From") + "\n"
				     + "Attack: " + thing.get("5 Attack") + "\n";

		}
		
		return returnString;
	}
	
	public static ArrayList<Item> connect() {
		ArrayList<Item>itemList = new ArrayList<Item>();
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/Users/johnmortensen/.aws/credentials), and is in valid format.",
                    e);
        }
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        	.withCredentials(credentialsProvider)
            .withRegion("us-west-1")
            .build();

		DynamoDB dynamoDB = new DynamoDB(client);
	    Table table = dynamoDB.getTable("Terrorists");
	    ScanRequest scanRequest = new ScanRequest()
	    	    .withTableName("Terrorists");


	    ScanResult result = client.scan(scanRequest);
	    Item item;
	    Item item2;
	    Item item3;
	    Item item4;
	    Item item5;
	    Item item6;
	    Item item7;
	    Item item8;
	    Item item9;
	    

	    for(int x = 1; x <= 1; x++)
	    {

	    	item = table.getItem("TerroristID", "T001");
	    	item2 = table.getItem("TerroristID", "T002");
	    	item3 = table.getItem("TerroristID", "T003");
	    	item4 = table.getItem("TerroristID", "T004");
	    	item5 = table.getItem("TerroristID", "T005");
	    	item6 = table.getItem("TerroristID", "T006");
	    	item7 = table.getItem("TerroristID", "T007");
	    	item8 = table.getItem("TerroristID", "T008");
	    	item9 = table.getItem("TerroristID", "T009");

	    	
	    	itemList.add(item);
	    	itemList.add(item2);
	    	itemList.add(item3);
	    	itemList.add(item4);
	    	itemList.add(item5);
	    	itemList.add(item6);
	    	itemList.add(item7);
	    	itemList.add(item8);
	    	itemList.add(item9);

	    	/*System.out.println(item.getNumber("Id") + ": " 
	    			+ item.getString("Name"));*/
	    }
	    
	   /* TableDescription desc = table.describe();
	    System.out.print(desc);
	    Long itemCount = table.describe().getItemCount();
	    System.out.print(itemCount);
	   // Item item;
	    for(int x = 1; x <= itemCount; x++)
	    {
	    	item = table.getItem("Id", x);
	    	itemList.add(item);
	    	System.out.println(item.getNumber("Id") + ": " 
	    			+ item.getString("Name"));
	    }*/

		return itemList;
	}
	
	/*public static LinkedList<Product> BuildLL(int filter, String searchTerm){
		
		int sType;
		Product temp = null;
		LinkedList<Product> returnList = new LinkedList();
		ArrayList<Item>itemList = new ArrayList<Item>();
	    
	    ArrayList<Item>filtered = new ArrayList<Item>();
	    
	    switch(filter) {
		case 1:
			for(int y = 0; y<itemList.size(); y++)
			{
				String comp = itemList.get(y).getString("Category");
				if(comp.equals(searchTerm))
					filtered.add(itemList.get(y));
					
			}
			break;
		case 2:
			for(int y = 0; y<itemList.size(); y++)
			{
				String comp = itemList.get(y).getString("Name");
				if(comp.equals(searchTerm))
					filtered.add(itemList.get(y));
					
			}
			break;
		default:
			System.out.print("Something went wrong");
		}
	    
	    for(int z = 0; z <filtered.size(); z++)
	    {
	    	sType = GetProductType(filtered.get(z).getString("Category"));
	    	
    		
    		switch(sType) {
    		case 1:
    			 temp = new Clothing(filtered.get(z).getString("Material"));
    			break;
    		case 2:
    			 temp = new Electronic(filtered.get(z).getBoolean("Production"));
    			break;
    		case 3:
    			 temp = new Fresh(filtered.get(z).getInt("Calories"));
    			break;
    		case 4:
    			temp = new Game(filtered.get(z).getString("Genre"));
    			break;
			default:
				System.out.print("Error in creating temp object");
    		}
    		
    		temp.setID(filtered.get(z).getInt("Id"));
    		temp.setName(filtered.get(z).getString("Name"));
    		temp.setPrice(filtered.get(z).getFloat("Price"));
    		temp.setDescription(filtered.get(z).getString("Description"));
    		temp.setType(filtered.get(z).getString("Category"));
    		
    		returnList.add(temp);
	    }
	    
	    return returnList;
	}
     	
	private static int GetProductType(String type) {
		int retVal = 0;
		
		if(type.equalsIgnoreCase("Clothing"))
			retVal = 1;
		else if(type.equalsIgnoreCase("Electronics"))
			retVal = 2;
		else if(type.equalsIgnoreCase("Fresh"))
			retVal = 3;
		else if(type.equalsIgnoreCase("Game"))
			retVal = 4;
		
		return retVal;
	}
	private static ArrayList<Integer> GetRandomIntegers(){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int temp = 0;
		for(int i = 0; i < 5; i++){
			temp = RandomInt();
			while(nums.contains(temp))
				temp = RandomInt();
			nums.add(temp);
		}
		return nums;
	}
	private static int RandomInt(){
		Random rand = new Random();
		int retInt = rand.nextInt(20) + 1;
		return retInt;
	}
	public static CircleQueue<Product> BuildSplashLL(){
		CircleQueue<Product> returnQueue = new CircleQueue<Product>();
		ArrayList<Integer> selID = GetRandomIntegers();
		ArrayList<Item>items = connect();
		Product temp = null;
		int sType;
		for(int i = 0; i < 5; i++){
			
				Item thing = items.get(selID.get(i));
				
					sType = GetProductType(thing.getString("Category"));
	        		switch(sType) {
	        		case 1:
	        			 temp = new Clothing(thing.getString("Material"));
	        			break;
	        		case 2:
	        			 temp = new Electronic(thing.getBoolean("InStock"));
	        			break;
	        		case 3:
	        			 temp = new Fresh(thing.getInt("Calories"));
	        			break;
	        		case 4:
	        			temp = new Game(thing.getString("Genre"));
	        			break;
					default:
						System.out.print("Error in creating temp object");
					}
					temp.setID(thing.getInt("Id"));
					temp.setName(thing.getString("Name"));
					temp.setPrice(thing.getFloat("Price"));
					temp.setDescription(thing.getString("Description"));
					temp.setType(thing.getString("Category"));
					returnQueue.add(temp);
				}
		
		return returnQueue;
	}
	public static LinkedList<Product> AddToCart(LinkedList<Product> currentCart, int pID){
		ArrayList<Item>items = connect();
		Product temp = null;
		int sType;
		Item thing = items.get(pID);
		//if there are problems with building the cart this is where it originated. get(pID) may need to be changed to look for the actual Id in the items in the items list		
		sType = GetProductType(thing.getString("Category"));
	    switch(sType) {
	    	case 1:
	    		temp = new Clothing(thing.getString("Material"));
	        	break;
	        case 2:
	        	temp = new Electronic(thing.getBoolean("InStock"));
	        	break;
	        case 3:
	        	temp = new Fresh(thing.getInt("Calories"));
	      		break;
	       case 4:
	    	   temp = new Game(thing.getString("Genre"));
	    	   break;
		   default:
			   System.out.print("Error in creating temp object");
		   }
		temp.setID(thing.getInt("Id"));
		temp.setName(thing.getString("Name"));
		temp.setPrice(thing.getFloat("Price"));
		temp.setDescription(thing.getString("Description"));
		temp.setType(thing.getString("Category"));
		currentCart.add(temp);
				
		return currentCart;
	}
	
	public static Product getProd(String name) {
		
		int sType;
		Product temp = null;
		ArrayList<Item>items = connect();
		ArrayList<Item>filtered = new ArrayList<Item>();
		for(int x = 0; x < items.size(); x++)
		{
			if(items.get(x).getString("Name").equals(name))
				filtered.add(items.get(x));
		}
			
			for(int z = 0; z < filtered.size(); z++) {
				sType = GetProductType(filtered.get(z).getString("Category"));
        		switch(sType) {
        		case 1:
        			 temp = new Clothing(filtered.get(z).getString("Material"));
        			break;
        		case 2:
        			 temp = new Electronic(filtered.get(z).getBoolean("Production"));
        			break;
        		case 3:
        			 temp = new Fresh(filtered.get(z).getInt("Calories"));
        			break;
        		case 4:
        			temp = new Game(filtered.get(z).getString("Genre"));
        			break;
				default:
					System.out.print("Error in creating temp object");
				}
				temp.setID(filtered.get(z).getInt("Id"));
				temp.setName(filtered.get(z).getString("Name"));
				temp.setPrice(filtered.get(z).getFloat("Price"));
				temp.setDescription(filtered.get(z).getString("Description"));
				temp.setType(filtered.get(z).getString("Category"));
			}
		
		return temp;
	}
	
	
	public static String getProdTypeFromName(String name) {
		
		int sType;
		String ret = "";
		ArrayList<Item>items = connect();
		ArrayList<Item>filtered = new ArrayList<Item>();
		for(int x = 0; x < items.size(); x++)
		{
			if(items.get(x).getString("Name").equals(name))
				filtered.add(items.get(x));
		}
		for(int z = 0; z < filtered.size(); z++) 
			ret = filtered.get(z).getString("Category");
				
		
		return ret;
	}
*/
	
}