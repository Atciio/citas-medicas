package com.example.doctores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class DoctorSelectionFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel
    private lateinit var doctorAdapter: DoctorAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_doctor_selection, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Configurar RecyclerView con los datos de los doctores
        doctorAdapter = DoctorAdapter { doctor ->
            viewModel.setDoctor(doctor)
            findNavController().navigate(R.id.action_doctorSelectionFragment_to_appointmentDetailsFragment)
        }
        recyclerView.adapter = doctorAdapter

        val doctors = listOf(
            Doctor("Dr. Juan Pérez", "Cardiología", "Disponible"),
            Doctor("Dra. María García", "Dermatología", "No Disponible"),
            Doctor("Dr. Carlos López", "Neurología", "Disponible")
        )

        // Cargar la lista de doctores en el adaptador
        doctorAdapter.setDoctors(doctors)


        return view
    }
}
