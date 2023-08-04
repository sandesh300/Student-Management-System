package student_manage;

public class Student {
	private int studentId;
	private String studentName;
	private String studentPhone;
	private String studentCity;
	
	public int getstudentId()
    {
		return studentId;
	}
	public void setstudentId(int studentId)
	{
		this.studentId=studentId;
	}
	
	public String getstudentName()
	{
		return studentName;
	}
	public void setstudentName(String studentName)
	{
		this.studentName=studentName;
	}
	
	public String getstudentPhone()
	{
		return studentPhone;
	}
	public void setstudentPhone(String studentPhone)
	{
		this.studentPhone=studentPhone;
	}
	
	public String getstudentCity()
	{
		return studentCity;
	}
	public void setstudentCity(String studentCity)
	{
		this.studentCity=studentCity;
	}
	
	
	public Student(int studentId, String studentName, String studentPhone, String studentCity)
	{
		super();
		this.studentId=studentId;
		this.studentName=studentName;
		this.studentPhone=studentPhone;
		this.studentCity=studentCity;
	}
	
	public Student(String studentName, String studentPhone, String studentCity)
	{
		super();
		this.studentName=studentName;
		this.studentPhone=studentPhone;
		this.studentCity=studentCity;
	}
	
	public Student()
	{
		super();
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPhone=" + studentPhone
				+ ", studentCity=" + studentCity + "]";
	}


}
