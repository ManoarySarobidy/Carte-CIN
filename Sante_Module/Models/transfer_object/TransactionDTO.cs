namespace sante.Models.Dto;

public class TransactionDTO{

	public double credit {get; set;}
	public double debit {get; set;}
	public string date {get; set;}

	public void ToString(){
		Console.WriteLine(" Transaction of : " + date );
	}

}
