package taskTracker;

import java.util.*;
import javax.swing.*;
import java.io.*;
class Task{
	static int id_atual = -1;
	int id;
	String name;
	String desc;
	String status;
	
	Task(String name,String desc, String status){
		this.id = ++id_atual;
		this.name = name;
		this.desc = desc;
		this.status = status;
	}
	public void changeStatus() {
		int opc = Integer.parseInt(JOptionPane.showInputDialog("🔁 Change Task Status:\n0-Not Done\n1-In Progress\n2-Done"));
		switch(opc) {
			case 0:
				this.status = "notdone";
				break;
			case 1:
				this.status = "inprogress";
				break;
			case 2:
				this.status = "done";
				break;
			default:
				JOptionPane.showMessageDialog(null, "⚠️ Option not found!");
				break;
		}
	}
}
public class Main {

	public static void main(String[] args)throws IOException {
		Metodos m = new Metodos();
		List <Task> tasks = new ArrayList<>(); 
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Task Manager\n1-Register Task\n2-List Tasks\n3-List Tasks Not Done\n4-List Tasks In Progress\n5-List Tasks Done\n6-Save Tasks\n7-Load Tasks\n9-EXIT"));
			switch(opc) {
				case 1:
					tasks.add(m.CreateTask());
					break;
				case 2:
					m.SeeTasks(tasks);
					goToTask(m,tasks);
					break;
				case 3:
					m.SeeTasks(tasks,"notdone");
					goToTask(m,tasks);
					break;
				case 4:
					m.SeeTasks(tasks,"inprogress");
					goToTask(m,tasks);
					break;
				case 5:
					m.SeeTasks(tasks,"done");
					goToTask(m,tasks);
					break;
				case 6:
					m.saveTasks(tasks);
					break;
				case 7:
					m.loadTasks(tasks);
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "Leaving");
					break;
				default:
					JOptionPane.showMessageDialog(null, "⚠️ Option not found!");
					break;
			}
		}while(opc!=9);

	}
	public static void goToTask(Metodos m,List<Task> tasks) {
		if(tasks.isEmpty()) {
			return;
		}
		int id = Integer.parseInt(JOptionPane.showInputDialog("🔍 Enter the task ID to modify:"));
		if(m.SearchTask(tasks, id) != null) {
			menuTask(m.SearchTask(tasks, id),tasks);						
		}else {
			JOptionPane.showMessageDialog(null, "Task not found");
		}
	}
	public static void menuTask(Task task, List <Task> tasks) {
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Task: "+task.name+"\nDescription: "+task.desc+"\nStatus: "+task.status+"\n1-Change Name\n2-Change Description\n3-Change Status\n4-Delete Task\n9-Back"));
			switch(opc) {
				case 1:
					String name = JOptionPane.showInputDialog("Enter new task name");
					task.name = name;
					break;
				case 2:
					String desc = JOptionPane.showInputDialog("Enter new task description");
					task.desc = desc;
					break;
				case 3:
					task.changeStatus();
					break;
				case 4:
					int conf = JOptionPane.showConfirmDialog(null, "🗑️ Delete this task?");
	                if(conf == JOptionPane.YES_OPTION) {
	                    tasks.remove(task);
	                    JOptionPane.showMessageDialog(null, "✅ Task deleted successfully!");
	                    opc = 9; // sai do menu da tarefa
	                }
					break;
				case 9:
					
					break;
				default:
					JOptionPane.showMessageDialog(null, "⚠️ Option not found!");
					break;
			}
		}while(opc!=9);
	}

}
