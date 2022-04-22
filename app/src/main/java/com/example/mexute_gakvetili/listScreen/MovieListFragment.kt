package com.example.mexute_gakvetili.listScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mexute_gakvetili.Movie
import com.example.mexute_gakvetili.MoviesAdapter
import com.example.mexute_gakvetili.R
import com.example.mexute_gakvetili.databinding.FragmentMovieListBinding
import com.example.mexute_gakvetili.detailsScreen.MovieDetailsFragment

class MovieListFragment:Fragment() {
    private val binding get () = _binding!!
    private var _binding:FragmentMovieListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        binding.rvMovies.adapter = MoviesAdapter(
            mutableListOf(
                Movie(
                    "Total recall",
                    "https://i.scdn.co/image/ab67616d0000b273f528e423cc48728f36f7c353",
                ),
                Movie(
                    "Shawshank redemption",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
                Movie(
                    "Leon the professional",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
                Movie(
                    "Inception",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
                Movie("Usual suspects", "https://flxt.tmsimg.com/assets/p16422_p_v8_ag.jpg"),
                Movie("The Shining", "https://movieposters2.com/images/1511858-b.jpg"),
                Movie("American beauty", "https://flxt.tmsimg.com/assets/p23514_p_v12_ah.jpg"),
                Movie(
                    "Dark knight",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                ),
                Movie(
                    "Dark knight",
                    "https://upload.wikimedia.org/wikipedia/ka/8/81/ShawshankRedemptionMoviePoster.jpg",
                )
            )
        ).apply {
            setOnItemCLickListener{ movie: Movie, i: Int ->
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.flContent, MovieDetailsFragment.newInstance(movie.movieName, movie.picture))
                    addToBackStack(MovieDetailsFragment::javaClass.name)
                    commit()

                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}