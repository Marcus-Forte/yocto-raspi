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

## TODO

- Nvidia Jetson Nano images.