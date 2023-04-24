import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.monstrehunter.*
import com.example.monstrehunter.Inventaire.PageEquipement
import com.example.monstrehunter.Inventaire.PageIngredients
import com.example.monstrehunter.Inventaire.PagePotions
import com.example.monstrehunter.Inventaire.PageRunes
import com.example.monstrehunter.R.layout.activity_inventaire

class Inventaire : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_inventaire)

        val equipementButton = findViewById<Button>(R.id.equipement)
        val ingredientsButton = findViewById<Button>(R.id.ingredients)
        val potionsButton = findViewById<Button>(R.id.potions)
        val runesButton = findViewById<Button>(R.id.runes)

        equipementButton.setOnClickListener {
            // Code pour lancer la page Equipement
            startActivity(Intent(this, PageEquipement::class.java))
        }

        ingredientsButton.setOnClickListener {
            // Code pour lancer la page Ingredients
            startActivity(Intent(this, PageIngredients::class.java))
        }

        potionsButton.setOnClickListener {
            // Code pour lancer la page Potions
            startActivity(Intent(this, PagePotions::class.java))
        }

        runesButton.setOnClickListener {
            // Code pour lancer la page Runes
            startActivity(Intent(this, PageRunes::class.java))
        }
    }
}
