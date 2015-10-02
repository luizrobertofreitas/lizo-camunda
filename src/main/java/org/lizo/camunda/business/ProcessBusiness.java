package org.lizo.camunda.business;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.lizo.camunda.service.vo.LizoProcess;

/**
 * Business class for processes operations.
 * 
 * @author accurate
 *
 */
public final class ProcessBusiness {
	
	private final ProcessEngine processEngine;
	
	/**
	 * Default constructor
	 */
	public ProcessBusiness() {
		processEngine = BpmPlatform.getDefaultProcessEngine();
	}
	
	/**
	 * Create new process instance.
	 * 
	 * @return LizoProcess
	 */
	public LizoProcess create() {
		ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey("lizo-camunda");
		
		LizoProcess lp = new LizoProcess();
		
		if (pi != null) {
			Task task = processEngine.getTaskService()
					.createTaskQuery()
					.caseInstanceId(pi.getProcessInstanceId())
					.singleResult();
			if (task != null) {
				lp = convertTaskToLizoProcess(task);
				lp.setMessage("Process instance created!");
			}
			else {
				lp.setMessage("Failure when creating process instance");
			}
		}
		else {
			lp.setMessage("Failure when creating process instance");
		}
		
		return lp;
	}
	
	/**
	 * Find all process instances.
	 * 
	 * @param firstResult
	 * @param maxResults
	 * @return List of LizoProcess
	 */
	public List<LizoProcess> findAll(final int firstResult, final int maxResults) {
		List<Task> tasks = processEngine.getTaskService()
				.createTaskQuery()
				.listPage(firstResult, maxResults);
		
		List<LizoProcess> instances = new ArrayList<LizoProcess>();
		
		if (tasks != null && !tasks.isEmpty()) {
			
			for (Task t : tasks) {
				instances.add(convertTaskToLizoProcess(t));
			}
		}
		
		return instances;
	}
	
	private LizoProcess convertTaskToLizoProcess(final Task t) {
		
		LizoProcess lp = null;
		
		if (t != null) {
			lp = new LizoProcess();
			lp.setAssignee(t.getAssignee());
			lp.setCreationTime(t.getCreateTime());
			lp.setDescription(t.getDescription());
			lp.setMessage("Ok");
			lp.setName(t.getName());
			lp.setPriority(t.getPriority());
			lp.setProcessInstanceId(t.getProcessInstanceId());
		}
		
		return lp;
	}
}
