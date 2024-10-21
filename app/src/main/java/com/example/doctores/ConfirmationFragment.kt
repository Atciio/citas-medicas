package com.example.doctores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ConfirmationFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)
        val doctorInfo: TextView = view.findViewById(R.id.doctorInfo)
        val appointmentInfo: TextView = view.findViewById(R.id.appointmentInfo)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Mostrar resumen de la cita
        val doctor = viewModel.selectedDoctor.value
        val date = viewModel.appointmentDate.value
        val time = viewModel.appointmentTime.value

        doctorInfo.text = "${doctor?.nombre}, ${doctor?.especialidad}"
        appointmentInfo.text = "Date: $date, Time: $time"

        view.findViewById<Button>(R.id.btnConfirm).setOnClickListener {
            Toast.makeText(requireContext(), "Appointment Confirmed!", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
