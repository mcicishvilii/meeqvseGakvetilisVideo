package com.example.mexute_gakvetili.detailsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mexute_gakvetili.Movie
import com.example.mexute_gakvetili.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment():Fragment() {
    private var _binding:FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(inflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieNamefromCompanionObject = requireArguments().getString(KEY_MOVIE_NAME)
        val movieURLfromCompanionObject = requireArguments().getString(KEY_MOVIE_PIC)

        Glide.with(requireContext()).load(movieURLfromCompanionObject).into(binding.ivLargePoster)


        binding.tvMovieName.text = movieNamefromCompanionObject
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object{
        const val KEY_MOVIE_NAME = "KEY_MOVIE_NAME"
        const val KEY_MOVIE_PIC = "KEY_MOVIE_PIC"

        fun newInstance(movieName: String, picture:String) :MovieDetailsFragment{
            return MovieDetailsFragment().apply {
                arguments = bundleOf(KEY_MOVIE_NAME to movieName, KEY_MOVIE_PIC to picture)
            }
        }
    }
}