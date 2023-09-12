import React, { Fragment, useState, useEffect } from "react";
import { grey, blue } from '@mui/material/colors'
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import DeleteIcon from '@mui/icons-material/Delete';
import SubjectIcon from '@mui/icons-material/Subject';
import { convertBase64 } from "../../helpers/Converters";

import {
    Grid,
    Button,
    Dialog,
    DialogTitle,
    DialogActions,
    DialogContent,
    DialogContentText,
    Typography,
    IconButton
} from '@mui/material'




/************************************************
* Componente principal
***********************************************/
export const Files = (props) => {

    const {
        form,
        setForm
    } = props

    const [input, setInput] = useState();
    const [openModalAdjunto, setOpenModalAdjunto] = useState(false);
    const [confirModal, setConfirModal] = useState({
        open: false
    });

    const changeFileHandler = async (event) => {
        setInput(event.target);
        const formTemp = { ...form };
        const filesTemp = [...formTemp.images];
        for (let i = 0; i < event.target.files.length; i++) {
            const file_bytes = await convertBase64(event.target.files[i]);
            filesTemp.push({
                name: event.target.files[i].name,
                file: file_bytes,
            });
        }
        if (filesTemp.length > 5) {
            window.alert("la cantidad máxima de images permitidos es 5")
        } else {
            formTemp.images = filesTemp;
            console.log("files =", formTemp)
            setForm(formTemp);
        }
    };

    const fileName = () => {
        let retorno = ""
        if (form.images.length === 1) {
            const name = form.images[0].name;
            let result = "";
            if (name.length > 12) {
                result = name.slice(0, 12) + "...";
            } else {
                result = name;
            }
            retorno = result;
        } else if (form.images.length > 1) {
            retorno = form.images.length + " images";
        }

        return retorno
    };

    const DeleteFile = () => {
        const formTemp = { ...form };
        const filesTemp = [];
        formTemp.images = filesTemp;
        onCloseConfirmModal();
        setForm(formTemp);
        input.value = "";
    };

    const onCloseConfirmModal = () => {
        const tempModal = { ...confirModal };
        tempModal.open = false;
        setConfirModal(tempModal);
    };

    const OpenDeleteFile = () => {
        const tempModal = { ...confirModal };
        tempModal.open = true;
        tempModal.onAcceptClick = DeleteFile;
        tempModal.onCancelClick = onCloseConfirmModal;
        tempModal.onClose = onCloseConfirmModal;
        setConfirModal(tempModal);
    };

    const OpenFiles = () => {
        openModalListaAdjunto();
    };

    const DeleteOrFile = () => {
        let retorno = null;
        if (form.images.length === 0) {
            retorno = (<Typography variant="body2" style={{ color: blue[900], fontWeight: "bold" }}>
                Adjuntar imagen
            </Typography>)
        }
        if (form.images.length === 1)
            retorno = (
                <IconButton onClick={OpenDeleteFile}>
                    <DeleteIcon
                        style={{
                            fontSize: 20,
                            color: grey[700],
                        }}
                    />
                </IconButton>
            );
        if (form.images.length > 1)
            retorno = (
                <IconButton onClick={OpenFiles}>
                    <SubjectIcon
                        style={{
                            fontSize: 24,
                            color: blue[900],
                        }}
                    />
                </IconButton>
            );
        return retorno;
    };

    const openModalListaAdjunto = () => {
        setOpenModalAdjunto(true);
    };
    const closeModalListaAdjunto = () => {
        setOpenModalAdjunto(false);
    };

    return (
        <Fragment>

            <Dialog open={confirModal.open} onClose={confirModal.onClose} >
                <DialogContent>
                    <DialogContentText>
                        ¿Desea eliminar el archivo?
                    </DialogContentText>
                </DialogContent>
                <DialogActions style={{ display: "flex", justifyContent: "center" }}>
                    <Button
                        size="small" variant="contained" color='secondary'
                        onClick={confirModal.onAcceptClick}>
                        Aceptar
                    </Button>
                    <Button
                        size="small" variant="outlined" color='secondary'
                        onClick={confirModal.onCancelClick}
                    >
                        Cancelar
                    </Button>
                </DialogActions>
            </Dialog>

            <ModalListadoAdjuntos
                open={openModalAdjunto}
                close={closeModalListaAdjunto}
                images={form.images}
                formulario={form}
                setFormulario={setForm}
            />

            <Grid container alignItems="center">
                <Grid item >
                    <div >
                        {form.images.length < 5 ? (
                            <label className="custom-file-upload">
                                <AddCircleOutlineIcon
                                    style={{
                                        marginRight: "10px",
                                        fontSize: 20,
                                        color: blue[900],
                                    }}
                                />
                                <input
                                    id={"images"}
                                    onChange={changeFileHandler}
                                    type="file"
                                    multiple
                                    hidden
                                />
                            </label>
                        ) : null}
                    </div>
                </Grid>
                <Grid item >
                    <b>{fileName()}</b>
                </Grid>
                <Grid item>
                    {DeleteOrFile()}
                </Grid>
            </Grid>
        </Fragment>
    );
};


/******************************************
* Modal
******************************************/

const ModalListadoAdjuntos = (props) => {

    const {
        open,
        close,
        images,
        formulario,
        setFormulario
    } = props

    return (
        <>
            <Dialog open={open} onClose={close} fullWidth maxWidth="xs">
                <DialogTitle >
                    Listado de images adjuntos
                </DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        {
                            images ?
                                images.map((archivo) => {
                                    return <ItemListaArchivos
                                        key={archivo.name}
                                        item={archivo}
                                        formulario={formulario}
                                        setFormulario={setFormulario}
                                    />
                                })
                                :
                                <></>
                        }
                    </DialogContentText>
                </DialogContent>
                <DialogActions style={{ display: "flex", justifyContent: "center" }}>
                    <Button
                        variant="contained"
                        color="secondary"
                        onClick={close}
                    >
                        Cerrar ventana
                    </Button>
                </DialogActions>
            </Dialog>
        </>
    )
}


/******************************************
* Item lista
******************************************/

const ItemListaArchivos = (props) => {
    const {
        item,
        formulario,
        setFormulario
    } = props

    const [open, setOpen] = useState(false)

    const cerrar = () => {
        setOpen(false)
    }

    const eliminar = () => {
        const formTemp = { ...formulario };
        const filesTemp = [...formTemp.images].filter(f => f.name !== item.name);
        formTemp.images = filesTemp;
        setFormulario(formTemp);
        setOpen(false);
    }

    const abreviarNombre = (nombreArchivo) => {
        let nombre;
        if (nombreArchivo.length > 40) {
            nombre = nombreArchivo.slice(0, 40).concat("...");
        } else nombre = nombreArchivo;
        return nombre
    };



    return (
        <>
            <Grid container alignItems="center" >
                <Grid item xs={10} justifyContent="flex-start">
                    <Typography variant="body1" >{abreviarNombre(item.name)}</Typography>
                </Grid>
                <Grid item xs={2} justifyContent="flex-end">
                    <IconButton onClick={() => { setOpen(true) }}>
                        <DeleteIcon
                            style={{
                                position: "absolute",
                                marginTop: "-4px",
                                marginLeft: "5px",
                                fontSize: 20,
                                color: grey[700],
                            }}
                        />
                    </IconButton>

                </Grid>

                <Dialog open={open} onClose={() => { setOpen(false) }}>
                    <DialogContent>
                        "Eliminar archivo?"        
                    </DialogContent>
                    <DialogActions style={{ display: "flex", justifyContent: "center" }}>
                        
                        <Button
                            size="small"
                            variant="contained"
                            color='secondary'
                            onClick={eliminar}
                        >
                            Aceptar
                        </Button>
                              
                        <Button
                            size="small"
                            variant="outlined"
                            color='secondary'
                            onClick={cerrar}
                        >
                            Cerrar
                        </Button>
                    </DialogActions>
                </Dialog>
            </Grid>
        </>
    )
}