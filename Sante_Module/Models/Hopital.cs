namespace sante.Models;

public class Hopital{


	int id;
	string name;

	public string Name{
		get{
			return this.name;
		}
		set{
			this.name = value;
		}
	}

	public int Id{
		get{
			return this.id;
		}set{
			this.id = value;
		}
	}


}