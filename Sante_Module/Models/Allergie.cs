namespace sante.Models;

public class Allergie{
	
	int id;
	string nom;

	public int Id{
		get{ return this.id; }
		set{
			this.id = value;
		}
	}

	public string Nom{
		get{ return this.nom; }
		set{
			this.nom = value;
		}
	}

	public Allergie(){

	}

	public Allergie( int id, string nom ) {
		this.Id = id;
		this.Nom = nom;
	}
	

}