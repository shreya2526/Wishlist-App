package sc.android.wishlistapp

import android.content.Context
import androidx.room.Room
import sc.android.wishlistapp.data.WishDatabase
import sc.android.wishlistapp.data.WishRepository
import kotlin.getValue

object Graph {

    //database instance
    lateinit var database: WishDatabase

    //repository instance only loads when needed
    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    //initializing/building the database
    fun provide(context: Context){
        database = Room.databaseBuilder(
            context = context,
            klass = WishDatabase :: class.java,
            name = "wishlist.db"
        ).build()
    }

}