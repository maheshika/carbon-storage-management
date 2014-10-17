/*
 *  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.mapred.mgt;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;

import org.wso2.carbon.mapred.reporting.CarbonJobCoreReporter;
import org.wso2.carbon.mapred.reporting.CarbonJobReporter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.hadoop.mapred.JobCoreReporterFactory;

public class HadoopJobRunnerActivator implements BundleActivator {

	private Log log = LogFactory.getLog(HadoopJobRunnerActivator.class);
	@Override
	public void start(BundleContext bc) throws Exception {
		log.info("Starting HadoopJobRunner bundle.");
		ServiceFactory serviceFactory = new HadoopJobRunnerFactory();
		bc.registerService(HadoopJobRunnerFactory.class.getName(), serviceFactory, new Hashtable());
		Thread jobReporterCleanerThread = new Thread(new CarbonJobReporter.CarbonJobReporterMap());
		jobReporterCleanerThread.start();
		log.info("Registered HadoopJobRunner service.");
	}

	@Override
	public void stop(BundleContext bc) throws Exception {
		log.info("Stopping HadoopJobRunner bundle");
	}

}
