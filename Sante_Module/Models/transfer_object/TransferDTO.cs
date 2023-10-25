
namespace sante.Models.Dto;
public class TransferDTO {

	private string send;
	private string receive;
	private double montant;
	private string idDevise;

	public string Send{
		get{
			return this.send;
		}
		set{
			this.send = value;
		}
	}

	public string Receive{
		get{
			return this.receive;
		}
		set{
			this.receive = value;
		}
	}

	public double Montant{
		get{
			return this.montant;
		}set{
			if( value <= 0 ) throw new ArgumentException("Vous ne pouvez pas transferer une somme négative : " + value);
			this.montant = value;
		}
	}

	public string IdDevise{
		get{
			return this.idDevise;
		}set{
			this.idDevise = value;
		}
	}

}