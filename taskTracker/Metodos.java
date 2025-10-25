package taskTracker;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Metodos {
	public Task CreateTask() {
		String name = JOptionPane.showInputDialog("Type Task name");
		String desc = JOptionPane.showInputDialog("Type Task description");
		String status = "notdone";
		
		return (new Task(name,desc,status));
	}
	public void SeeTasks(List<Task> tasks) {
		SeeTasks(tasks,null);
	}
	public void SeeTasks(List<Task> tasks,String status) {
		if(tasks.isEmpty()) {
			JOptionPane.showMessageDialog(null,"No tasks found");
			return;
		}
		boolean showAll = (status == null || status.trim().isEmpty());
		System.out.println("Tasks:\nID | Name | Description | Status");
		for(Task i : tasks) {
			if(showAll || i.status.equalsIgnoreCase(status)) {
				String task = i.id+" | "+i.name+" | "+i.desc+" | "+i.status;
				System.out.println(task);
			}
		}
	}
	public Task SearchTask(List<Task> tasks,int id) {
		for(Task i : tasks) {
			if(i.id == id) {
				return i;
			}
		}
		return null;
	}
	public void saveTasks(List<Task> tasks) throws IOException{
		String fileName = "TASKS.txt";
		BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
		for(Task i : tasks) {
			w.write(Integer.toString(i.id));w.newLine();
			w.write(i.name);w.newLine();
			w.write(i.desc);w.newLine();
			w.write(i.status);w.newLine();
		}
		w.close();
	}
	public void loadTasks(List<Task> tasks)throws IOException{
		String fileName = "TASKS.txt";
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		tasks.clear();//limpo a lista para carregar o arquivo
		String linha;
		while((linha = r.readLine()) != null) {
			String name = r.readLine();
			String desc = r.readLine();
			String status = r.readLine();
			tasks.add(new Task(name,desc,status));
		}
		
		r.close();
	}
}
