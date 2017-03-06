package com.hazelcast.client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * 
 * @author bhawani.singh
 *
 */
public class HazelCastClient {
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("10.131.126.158");
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		IMap map = client.getMap("employee");
		System.out.println("Map Size:" + map.entrySet());
		// client.shutdown();
	}
}
