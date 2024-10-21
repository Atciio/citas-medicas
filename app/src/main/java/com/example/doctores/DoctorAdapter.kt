package com.example.doctores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(private val doctorClickListener: (Doctor) -> Unit) :
    RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    private val doctorsList = mutableListOf<Doctor>()

    // ViewHolder que representa cada ítem en la lista
    class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nombre)
        val specialtyTextView: TextView = itemView.findViewById(R.id.especialidad)
        val availabilityTextView: TextView = itemView.findViewById(R.id.disponibilidad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctorsList[position]
        holder.nameTextView.text = doctor.nombre
        holder.specialtyTextView.text = doctor.especialidad
        holder.availabilityTextView.text = doctor.disponibilidad

        // Configura el click listener para cada doctor
        holder.itemView.setOnClickListener {
            doctorClickListener(doctor)
        }
    }

    override fun getItemCount(): Int {
        return doctorsList.size
    }

    // Método para actualizar la lista de doctores
    fun setDoctors(doctors: List<Doctor>) {
        doctorsList.clear()
        doctorsList.addAll(doctors)
        notifyDataSetChanged()
    }
}
