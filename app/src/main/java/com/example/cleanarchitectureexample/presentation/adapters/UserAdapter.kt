package com.example.cleanarchitectureexample.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitectureexample.databinding.ItemUserBinding
import com.example.cleanarchitectureexample.domain.model.User

class UserAdapter(val userList: MutableList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        val userViewHolder = UserViewHolder(binding)
        return userViewHolder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.tvName.text = user.name
        holder.binding.tvUsername.text = user.username
        holder.binding.tvEmail.text = user.email
        holder.binding.tvPhone.text = user.phone
        holder.binding.tvWebsite.text = user.website
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}