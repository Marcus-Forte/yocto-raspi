# Yocyo-raspi

Simple, minimal example on building _custom_ Raspberryp 5 images.
Produces an image with a very simple distro with systemd, and console interface.

## Usage

1. Open folder in dev container.
2. `source /yocto/poky/oe-init-build-env`.
3. Add this layers with bitbake: 
- `bitbake-layers add-layer /yocto/workspace/meta-simple/`
- `bitbake-layers add-layer /yocto/workspace/meta-raspberrypi`
4. Change `build/local.conf` file:
- Add `MACHINE ?= "raspberrypi5"` for raspberry image or any qemu.
- Add `DISTRO ?= "myimg"` for the custom distro.
 
 
NOTE: If problem downloading kernel occurs, look into the log for the git command and simply run it from a terminal manually.

## Config

At `local.conf`:
- Add more packages with: `IMAGE_INSTALL:append = " <packages> ...`

## Build

- `bitbake my-img`

## Qemu

If a qemu machine was chosen, use (from dev container):
- `runqemu slirp nographics`

## Deploy

If you produce an image for a Raspberry board, make sure you copy them out of the container:
- `docker cp <container_id>:/yocto/build/tmp/deploy/images/<machine>/<image>.wic.gz .`
Example: `docker cp -L a7ac:/yocto/build/tmp/deploy/images/raspberrypi5/my-img-raspberrypi5.rootfs-20240619160220.wic.bz2 .`

Then, extract to disk. Example:
- `bzip2 -cd my-img-raspberrypi5.rootfs-20240619160220.wic.bz2 | sudo dd of=/dev/disk5 bs=10M status=progress`

## Access

The machine should be SSH accessible from a static ip: `192.168.1.10`. Make sure the host device has an IP in range.

### Wifi Hotspot
- https://wiki.somlabs.com/index.php/Connecting_to_WiFi_network_using_systemd_and_wpa-supplicant

## Kernel modifications
- https://wiki.koansoftware.com/index.php/Modify_the_linux_kernel_with_configuration_fragments_in_Yocto

## TODO

- Nvidia Jetson Nano images.
https://raspberrypi.stackexchange.com/questions/100195/automatically-create-hotspot-if-no-network-is-available