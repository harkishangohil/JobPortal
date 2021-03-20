package com.sparrow.seekerslibrary

data class JobseekerResponse(
    val message: String,
    val success: Boolean
)
data class personel_details_class(
        val detail: List<Detail>
)

data class Detail(
        val id: String,
        val mobile: String,
        val msg: String
)
data class education_data_class(
    val detail: List<education_details>
)

data class education_details(
    val msg: String
)

data class experiance_data_class(
    val detail: List<experiance_details>
)

data class experiance_details(
    val msg: String
)


data class proffesional_data_class(
    val detail: List<profestional_details>
)

data class profestional_details(
    val msg: String
)