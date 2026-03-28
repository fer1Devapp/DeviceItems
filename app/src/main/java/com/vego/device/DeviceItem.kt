package com.vego.device

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vego.device.ui.theme.DeviceTheme
import com.vego.device.ui.theme.Typography

@Composable
fun DeviceItemView(device: Device) {

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {

            // Icono con fondo circular
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {

                Text(
                    text = device.name,
                    style = Typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                device.data?.color?.let {
                    Text("Color: $it", style = Typography.bodyMedium)
                }

                device.data?.capacity?.let {
                    Text("Capacidad: $it", style = Typography.bodyMedium)
                }

                device.data?.price?.let {
                    Text(
                        text = "Precio: $$it",
                        style = Typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }

                device.data?.generation?.let {
                    Text("Generación: $it", style = Typography.bodyMedium)
                }
            }
        }
    }
}

