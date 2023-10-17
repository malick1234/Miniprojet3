package ca.qc.cgodin.mini_projet3.repository

import androidx.lifecycle.LiveData
import ca.qc.cgodin.mini_projet3.data.Student
import ca.qc.cgodin.mini_projet3.data.StudentDao

class StudentRepository(private val studentDao : StudentDao) {
    val allStudents: LiveData<List<Student>> = studentDao.getStudents()
    suspend fun insert(student: Student){
        studentDao.insert(student)
    }
    suspend fun deleteStudent(student: Student){
        studentDao.deleteStudent(student)
    }
    suspend fun updateStudent(student: Student){
        studentDao.updateStudent(student)
    }
}