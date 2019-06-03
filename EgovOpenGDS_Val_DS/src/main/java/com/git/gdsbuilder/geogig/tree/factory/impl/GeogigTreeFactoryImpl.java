/**
 * 
 */
package com.git.gdsbuilder.geogig.tree.factory.impl;

import com.git.gdsbuilder.geogig.tree.GeogigRemoteRepositoryTree;
import com.git.gdsbuilder.geogig.tree.GeogigRemoteRepositoryTree.EnGeogigRemoteRepositoryTreeType;
import com.git.gdsbuilder.geogig.tree.GeogigRepositoryTree;
import com.git.gdsbuilder.geogig.tree.GeogigRepositoryTree.EnGeogigRepositoryTreeType;
import com.git.gdsbuilder.geogig.tree.factory.GeogigTreeFactory;
import com.git.gdsbuilder.geoserver.DTGeoserverManager;
import com.git.gdsbuilder.geoserver.data.DTGeoserverManagerList;

public class GeogigTreeFactoryImpl implements GeogigTreeFactory {

	@Override
	public GeogigRepositoryTree createGeogigRepositoryTree(DTGeoserverManagerList dtGeoManagers,
			EnGeogigRepositoryTreeType type) {
		return new GeogigRepositoryTree(dtGeoManagers, type);
	}

	@Override
	public GeogigRepositoryTree createGeogigRepositoryTree(DTGeoserverManager dtGeoserver, String serverName,
			EnGeogigRepositoryTreeType type, String parent, String transactionId) {
		return new GeogigRepositoryTree(dtGeoserver, serverName, type, parent, transactionId);
	}

	@Override
	public GeogigRemoteRepositoryTree createGeogigRemoteRepositoryTree(DTGeoserverManager dtGeoserver,
			String serverName, EnGeogigRemoteRepositoryTreeType type, String parent, String local, boolean fetch) {
		// TODO Auto-generated method stub
		return new GeogigRemoteRepositoryTree(dtGeoserver, serverName, type, parent, local, fetch);
	}

}
