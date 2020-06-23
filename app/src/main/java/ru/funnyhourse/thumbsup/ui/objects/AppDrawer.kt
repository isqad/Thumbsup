package ru.funnyhourse.thumbsup.ui.objects

import android.view.View
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import ru.funnyhourse.thumbsup.MainActivity
import ru.funnyhourse.thumbsup.R
import ru.funnyhourse.thumbsup.ui.fragments.SettingsFragment

class AppDrawer(private val activity: MainActivity, private val toolbar: Toolbar) {
    private val accountHeader: AccountHeader =
        AccountHeaderBuilder().withActivity(activity)
            .withHeaderBackground(R.drawable.header).addProfiles(
                ProfileDrawerItem().withName("Andrew N. Shalaev").withEmail("+7 (912) 657-60-39")
            ).build()

    fun create() {
        DrawerBuilder().
            withActivity(activity).
            withToolbar(toolbar).
            withActionBarDrawerToggle(true).
            withSelectedItem(-1).
            withAccountHeader(accountHeader).
            addDrawerItems(
                PrimaryDrawerItem().
                withIdentifier(100).
                withIconTintingEnabled(true).
                withName(R.string.new_group).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_create_groups),

                PrimaryDrawerItem().
                withIdentifier(101).
                withIconTintingEnabled(true).
                withName(R.string.new_secret_chat).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_secret_chat),

                PrimaryDrawerItem().
                withIdentifier(102).
                withIconTintingEnabled(true).
                withName(R.string.new_channel).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_create_channel),

                PrimaryDrawerItem().
                withIdentifier(103).
                withIconTintingEnabled(true).
                withName(R.string.contacts).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_contacts),

                PrimaryDrawerItem().
                withIdentifier(104).
                withIconTintingEnabled(true).
                withName(R.string.calls).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_phone),

                PrimaryDrawerItem().
                withIdentifier(105).
                withIconTintingEnabled(true).
                withName(R.string.favorite).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_favorites),

                PrimaryDrawerItem().
                withIdentifier(106).
                withIconTintingEnabled(true).
                withName(R.string.settings).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_settings),

                DividerDrawerItem(),

                PrimaryDrawerItem().
                withIdentifier(107).
                withIconTintingEnabled(true).
                withName(R.string.invite_friends).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_invate),

                PrimaryDrawerItem().
                withIdentifier(108).
                withIconTintingEnabled(true).
                withName(R.string.faq).
                withSelectable(false).
                withIcon(R.drawable.ic_menu_help)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        7 -> activity.supportFragmentManager.beginTransaction().
                        addToBackStack(null).
                        replace(R.id.data_container,
                            SettingsFragment()
                        ).
                        commit()
                    }

                    return false
                }
            }).build()
    }
}