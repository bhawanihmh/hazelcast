package com.hazelcast.node;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.dao.JDBCEmployeeDAO;
import com.hazelcast.mapstore.EmployeeMapStore;

/**
 * 
 * @author bhawani.singh
 *
 */
public class HazelCastNodes {
	public static void main(String[] args) {
		Config cfg = new Config();
		ManagementCenterConfig mgc = new ManagementCenterConfig();
		mgc.setEnabled(true);
		mgc.setUrl("http://localhost:8080/mancenter");
		cfg.setManagementCenterConfig(mgc);
		MapConfig mapCfg = new MapConfig();
		mapCfg.setName("employee");
		mapCfg.setAsyncBackupCount(0);
		MapStoreConfig mapStoreCfg = new MapStoreConfig();
		mapStoreCfg.setImplementation(new EmployeeMapStore(new JDBCEmployeeDAO()));
		mapStoreCfg.setEnabled(true);
		mapCfg.setMapStoreConfig(mapStoreCfg);
		cfg.addMapConfig(mapCfg);
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
	}
}
