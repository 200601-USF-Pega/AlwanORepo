package project1.dao;

import java.util.List;

import project1.menu.CreateProject;


public interface IProjectRepo {
	public CreateProject addProject(CreateProject project);
	public List<CreateProject> viewProjects();
	public void removeProject(String name);

}
