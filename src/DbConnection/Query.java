package DbConnection;



public class Query {
	
	public static void main(String args[]) 
	{
		Databaseconnection db=new Databaseconnection();
		String delete=db.deletestatement("delete from sys.emp where id=2");
		String query=db.viewstatement("select * from sys.emp;");
		
		//System.out.println(query);
	}

}
