/**
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License. A copy of
 * the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
*/

package com.amazonaws.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class AddBurglars {

    public static void main(String[] args) throws Exception {
    	//connect();
    	//displayAll();
    	create();
    }
    public static Connection connect() {
		String url = "jdbc:sqlite:amazon2.db"; //url tells the driver manager where to locate the Database.db file
		Connection conn = null;
		
		//Attempts to connect to the database file
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn; //returns a connection object
	}
	
	//Displays all of the information that is stored in the table 
	public static void displayAll() throws InterruptedException{
		//Selecting the columns you'd like to get information from
        String sql = "BurglarID, 1 Prisoner#, 2 Name, 3 Amount Stolen, 4 State of Crime, 5 Date Apprehended, 6 Penalty, 7 Other Convictions";
        
        //Connecting to the database then preparing the objects to receive the info
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set, outputting the information row by row
            while (rs.next()) {
                System.out.println(rs.getString("BurglarID") +  "\t" + 
                                   rs.getInt("1 Prisoner#") + "\t" +
                                   rs.getString("2 Name") + "\t" +
                                   rs.getString("3 Amount Stolen") + "\t" +
                                   rs.getString("4 State of Crime") + "\t" +
                                   rs.getString("5 Date Apprehended") + "\t" +
                                   rs.getString("6 Penalty") + "\t" +
                                   rs.getString("7 Other Convictions"));
                
               // create(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
	
	public static void create() throws InterruptedException, SQLException
	{
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-1").build();
		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable("Burglars");
		
		// Build the item
		Item item = new Item()
		    .withPrimaryKey("BurglarID", "B007")
		    .withNumber("1 Prisoner#", 14)
		    .withString("2 Name", "Albert Frederick Nussbaum")
		    .withString("3 Amount Stolen", "$250,000")
		    .withString("4 State of Crime", "NY")
		    .withString("5 Date Apprehended", "November 4, 1962")
		    .withString("6 Penalty", "40 year imprisonment")
		    .withString("7 Other Convictions", "murder");
		
		// Write the item to the table
		PutItemOutcome outcome = table.putItem(item);
		
		//Display
		System.out.println("Added Burglar");
	}

    	
}

