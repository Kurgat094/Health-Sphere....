package com.example.firestore

import android.util.Log
import com.example.models.CartItem
import com.example.utils.Constants

import com.google.firebase.firestore.FirebaseFirestore

class Firestorecart {
    private val mFirestore = FirebaseFirestore.getInstance()
    fun addCartItem(cartItem: CartItem, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        mFirestore.collection(Constants.CART)
            .add(cartItem)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreClass", "Error adding cart item", e)
                onFailure(e)
            }
    }

    fun getCartItemsByUser(username: String, onSuccess: (List<CartItem>) -> Unit, onFailure: (Exception) -> Unit) {
        mFirestore.collection(Constants.CART)
            .whereEqualTo("username", username)
            .get()
            .addOnSuccessListener { result ->
                val cartItems = result.mapNotNull { document ->
                    document.toObject(CartItem::class.java)
                }
                onSuccess(cartItems)
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreClass", "Error fetching cart items", e)
                onFailure(e)
            }
    }

    // Remove an item from the cart
    fun removeCartItem(username: String, product: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        mFirestore.collection(Constants.CART)
            .whereEqualTo("username", username)
            .whereEqualTo("product", product)
            .get()
            .addOnSuccessListener { result ->
                if (!result.isEmpty) {
                    // Assuming only one document is returned
                    val documentId = result.documents[0].id
                    mFirestore.collection(Constants.CART)
                        .document(documentId)
                        .delete()
                        .addOnSuccessListener {
                            onSuccess()
                        }
                        .addOnFailureListener { e ->
                            Log.e("FirestoreClass", "Error removing cart item", e)
                            onFailure(e)
                        }
                } else {
                    // Handle case where item was not found
                    Log.w("FirestoreClass", "No matching cart item found")
                    onSuccess()  // Consider calling onFailure() or providing feedback to user
                }
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreClass", "Error checking cart item for removal", e)
                onFailure(e)
            }
    }

    fun getCartItemsByUserId(userId: String, onSuccess: (List<CartItem>) -> Unit, onFailure: (Exception) -> Unit) {
        mFirestore.collection(Constants.CART)
            .whereEqualTo("userId", userId)
            .get()
            .addOnSuccessListener { result ->
                val cartItems = result.mapNotNull { document ->
                    document.toObject(CartItem::class.java)
                }
                onSuccess(cartItems)
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreClass", "Error fetching cart items", e)
                onFailure(e)
            }
    }
}
