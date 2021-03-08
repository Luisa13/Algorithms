package ood.app;

import java.util.List;

import ood.exercises.ex2.CallCenter;
import ood.exercises.ex2.Employee;
import ood.exercises.ex2.Respondent;
import ood.exercises.ex2.Employee.Rank;
import ood.exercises.ex2.Manager;

public class CallCenterSystem {

	public static void main(String[] args) throws Exception {
		CallCenter center = CallCenter.getInstance();
		
		center.addEmployee("Pepe", "Martin", Rank.RESPONDENT);
		center.addEmployee("Pepe", "Calvo", Rank.MANAGER);
		center.addEmployee("Maria", "Gomez", Rank.DIRECTOR);
		center.addEmployee("Elvis", "Blau", Rank.DIRECTOR);

		
		center.dispatchCall();
		center.dispatchCall();
		center.dispatchCall();

	}

}
