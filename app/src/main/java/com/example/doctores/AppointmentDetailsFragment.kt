package com.example.doctores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class AppointmentDetailsFragment : Fragment() {
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_appointment_details, container, false)
        val datePicker: DatePicker = view.findViewById(R.id.datePicker)
        val timePicker: TimePicker = view.findViewById(R.id.timePicker)
        val doctorDetails: TextView = view.findViewById(R.id.doctorDetails)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Mostrar información del doctor seleccionado
        val selectedDoctor = viewModel.selectedDoctor.value
        doctorDetails.text = "${selectedDoctor?.nombre}, ${selectedDoctor?.especialidad}"

        // Almacenar fecha y hora en el ViewModel
        view.findViewById<Button>(R.id.btnNext).setOnClickListener {
            val date = "${datePicker.dayOfMonth}-${datePicker.month + 1}-${datePicker.year}"
            val time = "${timePicker.hour}:${timePicker.minute}"
            viewModel.setAppointmentDate(date)
            viewModel.setAppointmentTime(time)

            findNavController().navigate(R.id.action_appointmentDetailsFragment_to_confirmationFragment)
        }

        return view
    }
}
