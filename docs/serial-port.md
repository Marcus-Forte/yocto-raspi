# General documentation on the use of udev and systemd device events

## Add udev rule on kernel event

### Serial port example
- (optional?) Add file to (lib|etc)/udev/rules.d/serial.rules: `SUBSYSTEM=="tty", KERNEL=="ttyUSB0"`
- Reboot system
- Check `systemctl status dev-ttyUSB0.device`

### Systemd example
```
[Unit]
Description=My Application
After=dev-ttyUSB0.device

[Service]
Type=simple
ExecStart=/usr/bin/<app>

[Install]
WantedBy=multi-user.target
```

### Reference
- https://www.freedesktop.org/software/systemd/man/latest/systemd.unit.html