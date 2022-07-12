package com.minkiapps.shared

import com.minkiapps.shared.api.createApiService

const val JOKE_BASE_URL = "https://api.chucknorris.io/"
const val CHUCK_NORRIS_IMAGE_URL = "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTgwNTA1Mzc0MzgwNTMzMzky/gettyimages-150327735-copy.jpg"

private fun main() {
    createApiService().fetchJokes().subscribe { joke ->
        println(joke.toString())
    }
}