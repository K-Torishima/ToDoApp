package com.example.todoapp.page.create

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.CreateTodoFragmentBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateToDoFragment: Fragment(R.layout.create_todo_fragment) {

    private val viewModel: CreateToDoViewModel by viewModels()
    private var _binding: CreateTodoFragmentBinding? = null
    private val binding: CreateTodoFragmentBinding get() = _binding!!

    // https://qiita.com/Nabe1216/items/b26b03cbc750ac70a842
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this._binding = CreateTodoFragmentBinding.bind(view)
        setMenu()
        setError()
        setDone()
    }

    private fun setMenu() {
        // Menu設定
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_create, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_save -> {
                        save()
                    }
                }
                return  true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun save() {
        val title = binding.titleEdit.text.toString()
        val detail = binding.detailEdit.text.toString()

        // ViewModelに渡す
        viewModel.save(title, detail)
    }

    private fun setError() {
        // Error表示
        viewModel.errorMessage.observe(viewLifecycleOwner) { massage ->
            if (massage.isEmpty()) return@observe
            Snackbar.make(requireView(), massage, Snackbar.LENGTH_SHORT).show()
            // 画面回転するともう一度エラーが表示されちゃうのを防止
            viewModel.errorMessage.value = ""
        }
    }

    private fun setDone() {
        viewModel.done.observe(viewLifecycleOwner) { done ->
            if (!done) return@observe
            findNavController().popBackStack()
        }
    }
}