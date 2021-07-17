package tasksRepository;
import database.DBHandler;
import entity.Task;
import java.sql.*;
import java.util.ArrayList;


public class TasksRepository {
    private DBHandler dbHandler = new DBHandler();

    public void addTask(Task task) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO Task(taskName, deadline, status) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, task.getTaskName());
        preparedStatement.setString(2, task.getDeadline());
        preparedStatement.setBoolean(3, task.getStatus());
        preparedStatement.execute();

        preparedStatement.close();
    }

    public ArrayList<Task> getAll() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM task";
        ResultSet results = statement.executeQuery(query);

        ArrayList<Task> tasks = new ArrayList<Task>();

        while (results.next()) {
            int id = results.getInt("id");
            String taskName = results.getString("taskName");
            String deadline = results.getString("deadline");
            boolean status = results.getBoolean("status");

            tasks.add(new Task(id, taskName, deadline, status));
        }

        statement.close();

        return tasks;
    }

    public ArrayList<Task> findActiveTasks() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM task WHERE status = false";
        ResultSet results = statement.executeQuery(query);
        ArrayList<Task> tasks = new ArrayList<Task>();

        while (results.next()) {
            int id = results.getInt("id");
            String taskName = results.getString("taskName");
            String deadline = results.getString("deadline");
            boolean status = results.getBoolean("status");

            tasks.add(new Task(id, taskName, deadline, status));
        }

        statement.close();

        return tasks;
    }


    public void delete(Task task) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "DELETE FROM task WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, task.getID());

        preparedStatement.execute();

        preparedStatement.close();
    }


    public Task markTaskAsDone(Task task) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "UPDATE task SET status = true WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, task.getID());
        preparedStatement.execute();
        preparedStatement.close();

        return task;
    }

}

