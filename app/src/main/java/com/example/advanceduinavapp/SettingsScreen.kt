package com.example.advanceduinavapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class SettingItem(
    val title: String,
    val subtitle: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val type: SettingType
)

enum class SettingType {
    TOGGLE,
    NAVIGATION,
    INFO
}

@Composable
fun SettingsScreen() {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkMode by remember { mutableStateOf(false) }
    var autoSync by remember { mutableStateOf(true) }
    
    val settingsItems = listOf(
        SettingItem(
            "Notifications",
            "Receive push notifications and alerts",
            Icons.Default.Notifications,
            SettingType.TOGGLE
        ),
        SettingItem(
            "Dark Mode",
            "Enable dark theme for the app",
            Icons.Default.Settings,
            SettingType.TOGGLE
        ),
        SettingItem(
            "Auto Sync",
            "Automatically sync data in background",
            Icons.Default.Settings,
            SettingType.TOGGLE
        ),
        SettingItem(
            "Privacy & Security",
            "Manage your privacy settings and security",
            Icons.Default.Settings,
            SettingType.NAVIGATION
        ),
        SettingItem(
            "Help & Support",
            "Get help and contact support",
            Icons.Default.Info,
            SettingType.NAVIGATION
        ),
        SettingItem(
            "About",
            "App version and information",
            Icons.Default.Info,
            SettingType.INFO
        )
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Manage your app preferences",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Settings List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(settingsItems.size) { index ->
                val setting = settingsItems[index]
                
                when (setting.type) {
                    SettingType.TOGGLE -> {
                        when (index) {
                            0 -> ToggleSettingItem(
                                setting = setting,
                                checked = notificationsEnabled,
                                onCheckedChange = { notificationsEnabled = it }
                            )
                            1 -> ToggleSettingItem(
                                setting = setting,
                                checked = darkMode,
                                onCheckedChange = { darkMode = it }
                            )
                            2 -> ToggleSettingItem(
                                setting = setting,
                                checked = autoSync,
                                onCheckedChange = { autoSync = it }
                            )
                        }
                    }
                    SettingType.NAVIGATION -> {
                        NavigationSettingItem(
                            setting = setting,
                            onClick = { /* Handle navigation */ }
                        )
                    }
                    SettingType.INFO -> {
                        InfoSettingItem(setting = setting)
                    }
                }
            }
        }
    }
}

@Composable
fun ToggleSettingItem(
    setting: SettingItem,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .selectable(
                    selected = checked,
                    onClick = { onCheckedChange(!checked) },
                    role = Role.Switch
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = setting.icon,
                contentDescription = setting.title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = setting.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = setting.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}

@Composable
fun NavigationSettingItem(
    setting: SettingItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = setting.icon,
                contentDescription = setting.title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = setting.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = setting.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Navigate",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun InfoSettingItem(setting: SettingItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = setting.icon,
                contentDescription = setting.title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = setting.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Version 1.0.0",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}