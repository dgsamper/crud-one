/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author dgsamper
 */
public class ProjectController {
    
    public void save(Project project) throws RuntimeException {
        String sql = "INSERT INTO projects (name, desc,"
                + "createdAt, updatedAt) "
                + "VALUES (?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDesc());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();
        } catch(Exception ex) {
            throw new RuntimeException("Error. Project not saved" + ex.getMessage(), ex);    
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void update(Project project) throws RuntimeException {
        String sql = "UPDATE projects SET"               
                + "name = ?,"
                + "desc = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?,"
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDesc());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch(Exception ex) {
            throw new RuntimeException("Error. Project not updated" + ex.getMessage(), ex);    
        } 
        
        
    }
    
    public void removeById(int idProject) throws RuntimeException {
        String sql = "DELETE FROM projects WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            statement.execute(); 
        } catch(Exception ex) {
            throw new RuntimeException("Error. Project not deleted");
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        
    }
    
    public List<Project> getAll() throws RuntimeException {
        
        String sql = "SELECT * FROM projects";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDesc(resultSet.getString("desc"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                projects.add(project);
            }   
        } catch (Exception ex) {
            throw new RuntimeException("Error. Project not inserted");
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);   
        }
        return projects;    
    }
    
}
