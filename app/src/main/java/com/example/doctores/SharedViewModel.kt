package com.example.doctores

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val selectedDoctor = MutableLiveData<Doctor>()
    val appointmentDate = MutableLiveData<String>()
    val appointmentTime = MutableLiveData<String>()

    fun setDoctor(doctor: Doctor) {
        selectedDoctor.value = doctor
    }

    fun setAppointmentDate(date: String) {
        appointmentDate.value = date
    }

    fun setAppointmentTime(time: String) {
        appointmentTime.value = time
    }
}
