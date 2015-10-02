package org.lizo.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendInformationServiceTask implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" >>>>> Process " + execution.getProcessInstanceId());
		System.out.println(" >>>>> Sending information: customerId: " + execution.getVariable("customerId") + 
				" - amount: " + execution.getVariable("amount"));
	}

}
