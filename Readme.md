# Yocyo-raspi

Simple, minimal example on building <custom> raspberrypi5 images.

## Usage

1. Open folder in container.
2. `source /yocto/poky/oe-init-build-env` for raspberry || `source /yocto/poky/oe-init-build-env build-qemu` for qemu.
3. Add this layer in bitbake: `bitbake-layers add-layer /yocto/workspace/meta-hello/`
4. Select add `MACHINE ?= "raspberrypi5"` for raspberry image.
5. `bitbake my-img`
 - If problem downloading kernel occurs, look into the log for the
 git command and simply run it from a terminal manually.

## Config

At `local.conf`:
- Pick any machine.
- Use `DISTRO ?= "marcus"`

## Build

- `bitbake my-img`

## Qemu
If a qemu machine was chosen, use (from docker):
- `runqemu slirp nographics`